# -*-coding: utf-8-*-
import hashlib


class Weixin(object):
    def __init__(self, token=None):
        self.token = token

    def verify_request(self, signature=None, timestamp=None, nonce=None):
        if signature and timestamp and nonce:
            ararry = [self.token, str(timestamp), nonce]
            ararry.sort()
            new_signature = hashlib.sha1(''.join(ararry)).hexdigest()
            return new_signature == signature
