import { Http,Util } from '@/utils';
import SocArchivesServiceBase from './soc-archives-service-base';


/**
 * 社保档案服务对象
 *
 * @export
 * @class SocArchivesService
 * @extends {SocArchivesServiceBase}
 */
export default class SocArchivesService extends SocArchivesServiceBase {

    /**
     * Creates an instance of  SocArchivesService.
     * 
     * @param {*} [opts={}]
     * @memberof  SocArchivesService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}