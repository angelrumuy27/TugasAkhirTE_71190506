Feature: Test register functionality on register page

  Scenario Outline: Register ke aplikasi web

    Given pengguna membuka browser

    And pengguna ada di halaman register

    When pengguna memasukan "<password>" password "<confirmpassword>" confirmpassword dan "<username>" username

    And pengguna klik tombol create

    Then pengguna berada dihalaman login


    Examples:
      | password       | confirmpassword | username        |
      |                |                 |                 |
      | 12345678       | 12345678        |                 |
      |                |                 | angel@gmail.com |
      | 123456         | 1234567         | angel@gmail.com |
      | 12345678901234 | 12345678901234  | angel@gmail.com |
#       test case yg hasilnya sesuai requirement
      | 12345678       | 12345678        | angel.gmail.com |
      | 12345678       | 12345678        | angel@gmail.com |