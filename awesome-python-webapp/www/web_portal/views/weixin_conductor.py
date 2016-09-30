# -*-coding: utf-8-*-

from flask import Flask, Blueprint, request
from www.web_portal.views.weixin import Weixin

weixin_conductor = Blueprint('weixin_conductor', __name__)
app = Flask(__name__)


@weixin_conductor.route('/wx121', methods=['GET', 'POST'])
def wx():
    handler = Weixin('xiaody')
    is_valid = handler.verify_request(signature=request.args.get('signature'), timestamp=request.args.get('timestamp'),
                                      nonce=request.args.get('nonce'))
    if is_valid:
        if request.method == 'GET':
            print(request.args.get('echostr'))
            return request.args.get('echostr')
        elif request.method == 'POST':
            print('method not implement')
