#-*-coding: utf-8-*-
from www.web_portal import app


def main():
    app.run(host='0.0.0.0', port=3188, threaded=True, debug=True)


if __name__ == '__main__':
    main()
