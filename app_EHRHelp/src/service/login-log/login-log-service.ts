import { Http,Util } from '@/utils';
import LoginLogServiceBase from './login-log-service-base';


/**
 * 帐户使用记录服务对象
 *
 * @export
 * @class LoginLogService
 * @extends {LoginLogServiceBase}
 */
export default class LoginLogService extends LoginLogServiceBase {

    /**
     * Creates an instance of  LoginLogService.
     * 
     * @param {*} [opts={}]
     * @memberof  LoginLogService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}