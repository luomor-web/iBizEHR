import { Http,Util } from '@/utils';
import SALPERSONSTDServiceBase from './salpersonstd-service-base';


/**
 * 员工薪酬标准服务对象
 *
 * @export
 * @class SALPERSONSTDService
 * @extends {SALPERSONSTDServiceBase}
 */
export default class SALPERSONSTDService extends SALPERSONSTDServiceBase {

    /**
     * Creates an instance of  SALPERSONSTDService.
     * 
     * @param {*} [opts={}]
     * @memberof  SALPERSONSTDService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}