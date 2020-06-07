import { Http,Util } from '@/utils';
import AttEndenceTypeServiceBase from './att-endence-type-service-base';


/**
 * 考勤类型服务对象
 *
 * @export
 * @class AttEndenceTypeService
 * @extends {AttEndenceTypeServiceBase}
 */
export default class AttEndenceTypeService extends AttEndenceTypeServiceBase {

    /**
     * Creates an instance of  AttEndenceTypeService.
     * 
     * @param {*} [opts={}]
     * @memberof  AttEndenceTypeService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}