
gunicorn -k tornado -w 8 -b 0.0.0.0:3100 web_portal:app -t 6000000