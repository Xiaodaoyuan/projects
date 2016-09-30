from flask import Flask
from www.web_portal.views.apis import apis
from www.web_portal.views.weixin_conductor import weixin_conductor

app = Flask(__name__)

app.register_blueprint(apis, url_prefix='/api')
app.register_blueprint(weixin_conductor, url_prefix='/wx')
