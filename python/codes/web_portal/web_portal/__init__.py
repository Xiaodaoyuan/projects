# -*-coding: utf-8-*-
from flask import Flask

from codes.web_portal.web_portal.views.app_ui import app_ui

app = Flask(__name__)
app.register_blueprint(app_ui, url_prefix="/app")