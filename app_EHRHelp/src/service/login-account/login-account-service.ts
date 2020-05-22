import { Http,Util } from '@/utils';
import LoginAccountServiceBase from './login-account-service-base';


/**
 * 登录帐户***服务对象
 *
 * @export
 * @class LoginAccountService
 * @extends {LoginAccountServiceBase}
 */
export default class LoginAccountService extends LoginAccountServiceBase {

    /**
     * Creates an instance of  LoginAccountService.
     * 
     * @param {*} [opts={}]
     * @memberof  LoginAccountService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}