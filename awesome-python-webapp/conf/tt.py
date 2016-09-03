# -*- coding: utf-8 -*-

class Screen(object):
    @property
    def width(self):
        return self.__width

    @width.setter
    def width(self, value):
        self.__width = value

    @property
    def height(self):
        return self.__height

    @width.setter
    def height(self, value):
        self.__height = value

    @property
    def resolution(self):
        return self.__width * self.__height


# test:
s = Screen()
s.width = 1024
s.height = 768
print(s.height)
print(s.resolution)
assert s.resolution == 786432, '1024 * 768 = %d ?' % s.resolution
