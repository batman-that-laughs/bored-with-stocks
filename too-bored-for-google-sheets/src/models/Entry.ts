// entry model to be populated
export class Entry {

  constructor(
    public transactionType: string,
    public companyName: string,
    public companyCode: string,
    public accountName: string,
    public billDate: Date,
    public price: number,
    public quantity: number
  ){}

}
