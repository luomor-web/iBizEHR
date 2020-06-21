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
          name: 'pxadress',
          prop: 'pxadress',
          dataType: 'TEXT',
        },
        {
          name: 'xh',
          prop: 'xh',
          dataType: 'TEXT',
        },
        {
          name: 'approvalstatus',
          prop: 'approvalstatus',
          dataType: 'TEXT',
        },
        {
          name: 'shfs',
          prop: 'shfs',
          dataType: 'SSCODELIST',
        },
        {
          name: 'trmdemdeftionid',
          prop: 'trmdemdeftionid',
          dataType: 'PICKUP',
        },
        {
          name: 'npxqs',
          prop: 'npxqs',
          dataType: 'TEXT',
        },
        {
          name: 'pimpersonid',
          prop: 'pimpersonid',
          dataType: 'PICKUP',
        },
        {
          name: 'ormorgid',
          prop: 'ormorgid',
          dataType: 'PICKUP',
        },
        {
          name: 'jhnd',
          prop: 'jhnd',
          dataType: 'SSCODELIST',
        },
        {
          name: 'trmdemdeftionname',
          prop: 'trmdemdeftionname',
          dataType: 'PICKUPTEXT',
        },
        {
          name: 'srfmajortext',
          prop: 'trmdemdeftionname',
          dataType: 'PICKUPTEXT',
        },
        {
          name: 'srfdataaccaction',
          prop: 'trmtrainplanid',
          dataType: 'GUID',
        },
        {
          name: 'srfkey',
          prop: 'trmtrainplanid',
          dataType: 'GUID',
        },
        {
          name: 'jhlx',
          prop: 'jhlx',
          dataType: 'SSCODELIST',
        },
        {
          name: 'jhkssj',
          prop: 'jhkssj',
          dataType: 'DATE',
        },
        {
          name: 'ysze',
          prop: 'ysze',
          dataType: 'FLOAT',
        },
        {
          name: 'npxks',
          prop: 'npxks',
          dataType: 'FLOAT',
        },
        {
          name: 'jhjssj',
          prop: 'jhjssj',
          dataType: 'DATE',
        },
        {
          name: 'trmplanformuid',
          prop: 'trmplanformuid',
          dataType: 'PICKUP',
        },
        {
          name: 'pxnum',
          prop: 'pxnum',
          dataType: 'INT',
        },
        {
          name: 'trmtrainplan',
          prop: 'trmtrainplanid',
        },
      {
        name: 'n_trmdemdeftionname_like',
        prop: 'n_trmdemdeftionname_like',
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