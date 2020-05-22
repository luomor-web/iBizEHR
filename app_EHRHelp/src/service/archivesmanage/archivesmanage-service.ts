import { Http,Util } from '@/utils';
import ARCHIVESMANAGEServiceBase from './archivesmanage-service-base';


/**
 * 档案管理服务对象
 *
 * @export
 * @class ARCHIVESMANAGEService
 * @extends {ARCHIVESMANAGEServiceBase}
 */
export default class ARCHIVESMANAGEService extends ARCHIVESMANAGEServiceBase {

    /**
     * Creates an instance of  ARCHIVESMANAGEService.
     * 
     * @param {*} [opts={}]
     * @memberof  ARCHIVESMANAGEService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}