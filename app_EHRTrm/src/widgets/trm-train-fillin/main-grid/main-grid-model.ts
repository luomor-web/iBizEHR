/**
 * Main 部件模型
 *
 * @export
 * @class MainModel
 */
export default class MainModel {

	/**
	 * 是否是实体数据导出
	 *
	 * @returns {any[]}
	 * @memberof MainGridMode
	 */
	public isDEExport: boolean = false;

	/**
	 * 获取数据项集合
	 *
	 * @returns {any[]}
	 * @memberof MainGridMode
	 */
	public getDataItems(): any[] {
    if(this.isDEExport){
		  return [
      ]
    }else{
		  return [
        {
          name: 'trmdepartname',
          prop: 'trmdepartname',
          dataType: 'PICKUPTEXT',
        },
        {
          name: 'ormorgsectorid',
          prop: 'ormorgsectorid',
          dataType: 'PICKUP',
        },
        {
          name: 'ormorgid',
          prop: 'ormorgid',
          dataType: 'PICKUP',
        },
        {
          name: 'srfmajortext',
          prop: 'trmtrainfillinname',
          dataType: 'TEXT',
        },
        {
          name: 'srfkey',
          prop: 'trmtrainfillinid',
          dataType: 'GUID',
        },
        {
          name: 'srfdataaccaction',
          prop: 'trmtrainfillinid',
          dataType: 'GUID',
        },
        {
          name: 'jzrq',
          prop: 'jzrq',
          dataType: 'PICKUPDATA',
        },
        {
          name: 'zzdzs',
          prop: 'zzdzs',
          dataType: 'PICKUPDATA',
        },
        {
          name: 'jd',
          prop: 'jd',
          dataType: 'PICKUPDATA',
        },
        {
          name: 'trmtrainfillinid2',
          prop: 'trmtrainfillinid2',
          dataType: 'PICKUP',
        },
        {
          name: 'nd',
          prop: 'nd',
          dataType: 'PICKUPDATA',
        },
        {
          name: 'shortname',
          prop: 'shortname',
          dataType: 'PICKUPDATA',
        },
        {
          name: 'trmdepartid',
          prop: 'trmdepartid',
          dataType: 'PICKUP',
        },
        {
          name: 'trmtrainfillin',
          prop: 'trmtrainfillinid',
        },
      {
        name: 'n_ormorgname_like',
        prop: 'n_ormorgname_like',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'n_ormorgsectorname_like',
        prop: 'n_ormorgsectorname_like',
        dataType: 'PICKUPTEXT',
      },

        {
          name:'size',
          prop:'size'
        },
        {
          name:'query',
          prop:'query'
        },
        {
          name:'page',
          prop:'page'
        },
        {
          name:'sort',
          prop:'sort'
        },
        {
          name:'srfparentdata',
          prop:'srfparentdata'
        },
        // 前端新增修改标识，新增为"0",修改为"1"或未设值
        {
          name: 'srffrontuf',
          prop: 'srffrontuf',
          dataType: 'TEXT',
        },
      ]
    }
  }

}