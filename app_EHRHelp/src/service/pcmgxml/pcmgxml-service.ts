import { Http,Util } from '@/utils';
import PCMGXMLServiceBase from './pcmgxml-service-base';


/**
 * 高校名录服务对象
 *
 * @export
 * @class PCMGXMLService
 * @extends {PCMGXMLServiceBase}
 */
export default class PCMGXMLService extends PCMGXMLServiceBase {

    /**
     * Creates an instance of  PCMGXMLService.
     * 
     * @param {*} [opts={}]
     * @memberof  PCMGXMLService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}