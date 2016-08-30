# -*-coding: utf-8-*-
from codes.web_portal.web_portal import app


def main1():
    app.run(host='0.0.0.0', port=3100, threaded=True, debug=True)


if __name__ == "__main__":
    main1()
