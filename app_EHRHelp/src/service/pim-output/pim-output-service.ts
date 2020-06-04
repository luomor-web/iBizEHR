import { Http,Util } from '@/utils';
import PimOutputServiceBase from './pim-output-service-base';


/**
 * 产值表服务对象
 *
 * @export
 * @class PimOutputService
 * @extends {PimOutputServiceBase}
 */
export default class PimOutputService extends PimOutputServiceBase {

    /**
     * Creates an instance of  PimOutputService.
     * 
     * @param {*} [opts={}]
     * @memberof  PimOutputService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}