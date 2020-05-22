import { Http,Util } from '@/utils';
import PCMBDSQDServiceBase from './pcmbdsqd-service-base';


/**
 * 变动申请单（停用）服务对象
 *
 * @export
 * @class PCMBDSQDService
 * @extends {PCMBDSQDServiceBase}
 */
export default class PCMBDSQDService extends PCMBDSQDServiceBase {

    /**
     * Creates an instance of  PCMBDSQDService.
     * 
     * @param {*} [opts={}]
     * @memberof  PCMBDSQDService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}