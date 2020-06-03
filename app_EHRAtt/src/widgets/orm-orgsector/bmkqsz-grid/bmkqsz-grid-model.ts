/**
 * BMKQSZ 部件模型
 *
 * @export
 * @class BMKQSZModel
 */
export default class BMKQSZModel {

	/**
	 * 是否是实体数据导出
	 *
	 * @returns {any[]}
	 * @memberof BMKQSZGridMode
	 */
	public isDEExport: boolean = false;

	/**
	 * 获取数据项集合
	 *
	 * @returns {any[]}
	 * @memberof BMKQSZGridMode
	 */
	public getDataItems(): any[] {
    if(this.isDEExport){
		  return [
      ]
    }else{
		  return [
        {
          name: 'prodepid',
          prop: 'prodepid',
          dataType: 'PICKUP',
        },
        {
          name: 'zzdzs',
          prop: 'zzdzs',
          dataType: 'PICKUPDATA',
        },
        {
          name: 'orgid',
          prop: 'orgid',
          dataType: 'PICKUP',
        },
        {
          name: 'proleaderid',
          prop: 'proleaderid',
          dataType: 'PICKUP',
        },
        {
          name: 'pimpersonid',
          prop: 'pimpersonid',
          dataType: 'PICKUP',
        },
        {
          name: 'ormxmglid',
          prop: 'ormxmglid',
          dataType: 'PICKUP',
        },
        {
          name: 'orgname',
          prop: 'orgname',
          dataType: 'PICKUPTEXT',
        },
        {
          name: 'porgsectorid',
          prop: 'porgsectorid',
          dataType: 'PICKUP',
        },
        {
          name: 'orgsectorname',
          prop: 'orgsectorname',
          dataType: 'TEXT',
        },
        {
          name: 'srfmajortext',
          prop: 'orgsectorname',
          dataType: 'TEXT',
        },
        {
          name: 'srfdataaccaction',
          prop: 'orgsectorid',
          dataType: 'GUID',
        },
        {
          name: 'srfkey',
          prop: 'orgsectorid',
          dataType: 'GUID',
        },
        {
          name: 'ormorgsector',
          prop: 'orgsectorid',
        },
      {
        name: 'n_zzdzs_like',
        prop: 'n_zzdzs_like',
        dataType: 'PICKUPDATA',
      },
      {
        name: 'n_orgsectorname_like',
        prop: 'n_orgsectorname_like',
        dataType: 'TEXT',
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