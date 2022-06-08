Feature: Test to check password validation
  Scenario: Panjang passsword tidak boleh kurang dari 8 atau lebih dari 13
    Given Pengguna membuka mesin pencarian(browser)
    And pengguna berada dihalaman register
    When pengguna membuat password dengan panjang kurang dari delapan atau lebih dari tiga belas
    And pengguna menekan tombol create
    Then gagal membuat akun