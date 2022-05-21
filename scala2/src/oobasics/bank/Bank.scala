package oobasics.bank

class Bank {
  
  private var _customer: List[Customer] = Nil
  private var _accounts: List[Account] = Nil
  private var nextCustomerID: Int = 0
  private var nextAccountID: Int = 0  
  
  def addCustomer(fname: String, lname: String, address:Address):Unit = {
    nextCustomerID += 112
    _customer ::= new Customer(fname, lname, nextCustomerID.toString(), address)
  }
  
  def openAccount(c: Customer): Account = {
    nextAccountID += 120
    val account = new Account(c, nextAccountID.toString())
    _accounts ::= account
    account            //return newly created account
  }
  
  def closeAccount(a: Account): Boolean = {
    if (_accounts.contains(a)) { 
    _accounts = _accounts.filter(_ != a)
    if (!a.customer.removeAccount(a.id)) {
      println("Account doesn't belong to customer")
    }
    true
  } else false
  }
  
  def findCustomer(fname: String, lname: String): Option[Customer] = {
    _customer.find(c => c.firstName == fname && c.lastName == lname)
  }
  
  def findCustomer(id:String):Option[Account] = {
    _accounts.find(a => a.id == id)
  }
  
  
}