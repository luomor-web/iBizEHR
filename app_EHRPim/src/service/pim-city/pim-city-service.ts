import { Http,Util } from '@/utils';
import PimCityServiceBase from './pim-city-service-base';


/**
 * 市服务对象
 *
 * @export
 * @class PimCityService
 * @extends {PimCityServiceBase}
 */
export default class PimCityService extends PimCityServiceBase {

    /**
     * Creates an instance of  PimCityService.
     * 
     * @param {*} [opts={}]
     * @memberof  PimCityService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}