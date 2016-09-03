# -*-coding: utf-8-*-

import re
import json
from flask import request, Response
import logging
import traceback
from www.web_portal.views.constant import REQUEST_SUCCESS, REQUEST_FAIL


def interceptor(pattern='/'):
    def decorator(func):
        func.__interceptor__ = build_pattern(pattern)
        return func

    return decorator


_RE_INTERCEPTROR_STARTS_WITH = re.compile(r'^([^\*\?]+)\*?$')
_RE_INTERCEPTROR_ENDS_WITH = re.compile(r'^\*([^\*\?]+)$')


def build_pattern(pattern):
    m = _RE_INTERCEPTROR_STARTS_WITH.match(pattern)
    if m:
        return lambda p: p.startswith(m.group(1))
    m = _RE_INTERCEPTROR_ENDS_WITH.match(pattern)
    if m:
        return lambda p: p.endswith(m.group(1))
    raise ValueError('Invalid pattern definition in interceptor.')


def return_data(code=REQUEST_SUCCESS, result=None, message=u'', status_code=200):
    result = {} if result is None else result
    result_json = json.dumps({'code': code, 'message': message, 'result': result})

    logging.debug('url: %s, [result: %s]' % (str(request.url), str(result_json)))

    return Response(result_json, status_code, mimetype='application/json')


def request_fail():
    error = traceback.format_exc()
    logging.error(error)
    result = {'error': error} if error is not None else None
    return return_data(code=REQUEST_FAIL, result=result, message=u'系统出现异常，请稍后再试!', status_code=400)
