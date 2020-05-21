import { Http,Util } from '@/utils';
import OrgSecUserTypeServiceBase from './org-sec-user-type-service-base';


/**
 * 部门人员关系类型服务对象
 *
 * @export
 * @class OrgSecUserTypeService
 * @extends {OrgSecUserTypeServiceBase}
 */
export default class OrgSecUserTypeService extends OrgSecUserTypeServiceBase {

    /**
     * Creates an instance of  OrgSecUserTypeService.
     * 
     * @param {*} [opts={}]
     * @memberof  OrgSecUserTypeService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}