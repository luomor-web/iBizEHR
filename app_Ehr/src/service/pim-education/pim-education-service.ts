import { Http,Util } from '@/utils';
import PimEducationServiceBase from './pim-education-service-base';


/**
 * 教育信息服务对象
 *
 * @export
 * @class PimEducationService
 * @extends {PimEducationServiceBase}
 */
export default class PimEducationService extends PimEducationServiceBase {

    /**
     * Creates an instance of  PimEducationService.
     * 
     * @param {*} [opts={}]
     * @memberof  PimEducationService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}