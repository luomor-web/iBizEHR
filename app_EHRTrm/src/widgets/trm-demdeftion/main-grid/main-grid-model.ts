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
          name: 'trmtraincourseid',
          prop: 'trmtraincourseid',
          dataType: 'PICKUP',
        },
        {
          name: 'xh',
          prop: 'xh',
          dataType: 'TEXT',
        },
        {
          name: 'pxrs',
          prop: 'pxrs',
          dataType: 'INT',
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
          dataType: 'TEXT',
        },
        {
          name: 'pxdd',
          prop: 'pxdd',
          dataType: 'TEXT',
        },
        {
          name: 'trmtrainfillinid',
          prop: 'trmtrainfillinid',
          dataType: 'PICKUP',
        },
        {
          name: 'trmdemdeftionname',
          prop: 'trmdemdeftionname',
          dataType: 'TEXT',
        },
        {
          name: 'srfmajortext',
          prop: 'trmdemdeftionname',
          dataType: 'TEXT',
        },
        {
          name: 'srfdataaccaction',
          prop: 'trmdemdeftionid',
          dataType: 'GUID',
        },
        {
          name: 'srfkey',
          prop: 'trmdemdeftionid',
          dataType: 'GUID',
        },
        {
          name: 'trmtraincoursename',
          prop: 'trmtraincoursename',
          dataType: 'PICKUPTEXT',
        },
        {
          name: 'ormorgname',
          prop: 'ormorgname',
          dataType: 'PICKUPTEXT',
        },
        {
          name: 'xqfl',
          prop: 'xqfl',
          dataType: 'SSCODELIST',
        },
        {
          name: 'pxmk',
          prop: 'pxmk',
          dataType: 'SSCODELIST',
        },
        {
          name: 'bmjzsj',
          prop: 'bmjzsj',
          dataType: 'DATE',
        },
        {
          name: 'trmdepartid',
          prop: 'trmdepartid',
          dataType: 'PICKUP',
        },
        {
          name: 'pxkssj',
          prop: 'pxkssj',
          dataType: 'DATE',
        },
        {
          name: 'pxdx',
          prop: 'pxdx',
          dataType: 'TEXT',
        },
        {
          name: 'pxjssj',
          prop: 'pxjssj',
          dataType: 'DATE',
        },
        {
          name: 'trmdemdeftion',
          prop: 'trmdemdeftionid',
        },
      {
        name: 'n_trmdemdeftionname_like',
        prop: 'n_trmdemdeftionname_like',
        dataType: 'TEXT',
      },
      {
        name: 'n_pxmk_eq',
        prop: 'n_pxmk_eq',
        dataType: 'SSCODELIST',
      },
      {
        name: 'n_pxkssj_gtandeq',
        prop: 'n_pxkssj_gtandeq',
        dataType: 'DATE',
      },
      {
        name: 'n_pxjssj_ltandeq',
        prop: 'n_pxjssj_ltandeq',
        dataType: 'DATE',
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