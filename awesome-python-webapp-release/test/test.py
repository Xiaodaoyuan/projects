# -*- coding: utf-8 -*-

__author__ = 'xiaody'


class User(dict):
    def __init__(self, **kw):
        super(User, self).__init__(**kw)


if __name__ == '__main__':
    user = User(1, "xiao")
    print(user.get('id'))
