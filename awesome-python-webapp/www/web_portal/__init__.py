
from flask import Flask
from www.web_portal.views.apis import apis

app = Flask(__name__)

app.register_blueprint(apis, url_prefix='/api')