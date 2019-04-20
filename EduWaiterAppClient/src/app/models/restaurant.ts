import {Menu} from "./menu";
import {AdminAccount} from "./admin-account";
import {EmployeeAccount} from "./employee-account";
import {Fact} from "./fact";

export class Restaurant {

  id: number;
  name: string;
  menus: Menu[];
  admins: AdminAccount[];
  employees: EmployeeAccount[];
  facts: Fact[];


}
