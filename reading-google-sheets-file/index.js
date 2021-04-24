// require the module
const fileReader = require('xlsx');

// read the file
const xlFile = fileReader.readFile('./import_file_21_04_2021_kaushal.xlsx');



// read sheet names
const sheets = xlFile.SheetNames;

// initializing epmty data arrays to read content
let purchaseData = [];
let saleData = [];

// get data for particular sheet by name in array of json format 
for( let i=0; i < sheets.length; i++){
    const sheetData = fileReader.utils.sheet_to_json(xlFile.Sheets[sheets[i]]);
    sheetData.forEach(element => {
        if(element['PUR-DATE']){
            let purchaseEntry ={
                type: "purchase",
                companyName: element['NAME OF CO'],
                quantity: element['QTY'],
                date: element['PUR-DATE'],
                price: element['PUR-RATE'],
                accountHolder: sheets[i]
            };
            purchaseData.push(purchaseEntry);
        }

        if(element['SALE-DATE']){
            let saleEntry ={
                type: "sale",
                companyName: element['NAME OF CO'],
                quantity: element['QTY'],
                date: element['SALE-DATE'],
                price: element['SALE-RATE'],
                accountHolder: sheets[i]
            };
            saleData.push(saleEntry);
        }

    });
}

// print data:
console.log(purchaseData);
console.log(saleData);