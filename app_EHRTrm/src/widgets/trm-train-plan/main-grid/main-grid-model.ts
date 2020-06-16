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
          name: 'xh',
          prop: 'xh',
          dataType: 'TEXT',
        },
        {
          name: 'trmdemdeftionid',
          prop: 'trmdemdeftionid',
          dataType: 'PICKUP',
        },
        {
          name: 'pxrs',
          prop: 'pxrs',
          dataType: 'PICKUPDATA',
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
          name: 'pxzynr',
          prop: 'pxzynr',
          dataType: 'PICKUPDATA',
        },
        {
          name: 'pxdd',
          prop: 'pxdd',
          dataType: 'PICKUPDATA',
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
          name: 'pxkssj',
          prop: 'pxkssj',
          dataType: 'PICKUPDATA',
        },
        {
          name: 'pxdx',
          prop: 'pxdx',
          dataType: 'PICKUPDATA',
        },
        {
          name: 'pxjssj',
          prop: 'pxjssj',
          dataType: 'PICKUPDATA',
        },
        {
          name: 'trmplanformuid',
          prop: 'trmplanformuid',
          dataType: 'PICKUP',
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