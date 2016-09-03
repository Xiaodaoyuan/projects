# -*-coding: utf-8-*-

from flask import Flask, Blueprint, render_template, Response, redirect, request
from www.web_portal.views.common import interceptor
import json
import requests
import time
import hashlib
from www.web_portal.views.constant import COOKIE_KEY, API_URL
from www.web_portal.views.common import return_data, request_fail

apis = Blueprint('apis', __name__)
app = Flask(__name__)

_COOKIE_NAME = 'awesession'


@interceptor('/manage/')
def manage_interceptor(next):
    user = request.user
    if user and user.admin:
        return next()
    return redirect('/signin')


@apis.route("/", methods=['GET'])
@apis.route("/index", methods=['GET'])
def index():
    resp = requests.post('http://localhost:8080/users/login')
    if resp.status_code == 200:
        print(resp.json())
    return render_template('__base__.html', blog=json.dumps(resp.json()))


@apis.route("/signin", methods=['GET'])
def login():
    return render_template('signin.html')


@apis.route("/authenticate", methods=['POST'])
def authenticate():
    request_data = json.loads(request.data)
    remember = request_data.get('remember')
    data = {'mobile': request_data.get('mobile'), 'passowrd': request_data.get('password')}
    resp = requests.post(API_URL + "users/login/password", data=json.dumps(data))
    if resp.status_code == 200 and resp.content:
        user = resp.json()
        max_age = 604800 if remember == 'true' else None
        cookie = make_signed_cookie(user.id, user.password, max_age)
        response.set_cookie(_COOKIE_NAME, cookie, max_age=max_age)
        user['passowrd'] = '******'
    return return_data(result=user)


def make_signed_cookie(id, password, max_age):
    expires = str(int(time.time() + (max_age or 86400)))
    cookies = [id, expires, hashlib.md5('%s-%s-%s-%s' % (id, password, expires, COOKIE_KEY)).hexdigest()]
    return '-'.join(cookies)


def parse_signed_cookie(cookie_str):
    try:
        cookies = cookie_str.split('-')
        if len(cookies) != 3:
            return None
        id, expires, md5 = cookies
        if int(expires) < time.time():
            return None
        user = get_user_by_id(id)
        if user is None:
            return None
        if md5 != hashlib.md5('%s-%s-%s-%s' % (id, user.get('password'), expires, COOKIE_KEY)).hexdigest():
            return None
        return user
    except:
        return None


def get_user_by_id(id):
    user = None
    if id is not None:
        user_resp = requests.get(API_URL + "users/" + id)
        if user_resp.status_code == 200 and user_resp.content:
            user = user_resp.json()
    return user
