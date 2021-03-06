Feature: Test Login functionality on login page

  Scenario Outline: Login ke aplikasi web

    Given pengguna buka browser

    And pengguna berada pada halaman login

    When pengguna menginput "<password>" password dan "<username>" username

    And pengguna menekan tombol login

    Then pengguna berada dihalaman home


    Examples:
      | password  | username        |
      |           |                 |
      |           | angel@gmail.com |
      | 12345^&*= | angel@gmail.com |
#       test case yg hasilnya sesuai requirement
      | 15678     |                 |
      | 12345678  | angel@gmail.com |
