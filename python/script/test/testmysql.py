import mysql.connector


def get_conn():
    conn = mysql.connector.connect(user='root', password='root', database='shopping')
    return conn


def test():
    conn = get_conn()
    print(conn)
    cursor = conn.cursor()
    cursor.execute('select * from account')
    values = cursor.fetchall()
    print(values)
    cursor.close()
    conn.close()


if __name__ == "__main__":
    test()
