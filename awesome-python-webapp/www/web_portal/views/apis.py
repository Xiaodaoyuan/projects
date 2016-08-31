# -*-coding: utf-8-*-

from flask import Flask, Blueprint, render_template
import json
import requests

apis = Blueprint('apis', __name__)
app = Flask(__name__)


@apis.route("/login")
def hello():
    resp = requests.post('http://localhost:8080/users/login')
    if resp.status_code == 200:
        print(resp.json())
    return render_template('blog.html', blog=json.dumps(resp.json()))
