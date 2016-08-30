# -*-coding: utf-8-*-
from flask import Blueprint, Flask

app_ui = Blueprint('app_ui', __name__)
app = Flask(__name__)


@app_ui.route("/hello", methods=['GET'])
def hello():
    return "hello"

if __name__ == '__main__':
    app.run()
