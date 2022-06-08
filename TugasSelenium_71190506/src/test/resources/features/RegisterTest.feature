Feature: Test register functionality on register page

  Scenario: Username dan password harus diisi

    Given pengguna membuka browser

    And user berada di halaman register

    When username atau password kosong

    And user klik tombol create

    Then user tetap berada dihalaman register