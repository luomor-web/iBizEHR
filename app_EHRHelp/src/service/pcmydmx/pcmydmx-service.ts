import { Http,Util } from '@/utils';
import PCMYDMXServiceBase from './pcmydmx-service-base';


/**
 * 异动明细服务对象
 *
 * @export
 * @class PCMYDMXService
 * @extends {PCMYDMXServiceBase}
 */
export default class PCMYDMXService extends PCMYDMXServiceBase {

    /**
     * Creates an instance of  PCMYDMXService.
     * 
     * @param {*} [opts={}]
     * @memberof  PCMYDMXService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}