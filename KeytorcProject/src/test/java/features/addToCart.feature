@AddAndDeleteProductToCart
Feature: AddAndDeleteProductToShoppingCart

    @Cart
    Scenario: Add To Cart
      Given go to url
      Then check homepage title
      When click lighting text button
      When click login button
      Then check login page
      When write "berfinhazalkaya@gmail.com" in email part
      When write "123456berfin." in password part
      When click show button
      When click login button in login page
      When write "samsung" in search box
      When click search icon
      Then check product page
      When click second page
      Then check second page
      When add the 3. product to favorite
      When click close button
      When click favorite button
      Then check favorite page
      When click my favorites button
      Then check the product on favorite page
      When click delete button
      When click okey button
      Then check favorites page is empty







