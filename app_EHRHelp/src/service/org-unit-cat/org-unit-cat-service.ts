import { Http,Util } from '@/utils';
import OrgUnitCatServiceBase from './org-unit-cat-service-base';


/**
 * 组织单元类别服务对象
 *
 * @export
 * @class OrgUnitCatService
 * @extends {OrgUnitCatServiceBase}
 */
export default class OrgUnitCatService extends OrgUnitCatServiceBase {

    /**
     * Creates an instance of  OrgUnitCatService.
     * 
     * @param {*} [opts={}]
     * @memberof  OrgUnitCatService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}