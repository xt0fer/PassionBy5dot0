export class User {
    userName: string;
    password: string;
    accountType: string;
    activeAccount : Account;
    accounts : Account[];
    }

export class Account{
    id: number;
    accountName: string;

}