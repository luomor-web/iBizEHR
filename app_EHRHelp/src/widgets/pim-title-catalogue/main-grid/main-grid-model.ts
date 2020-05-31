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
          name: 'pimtitlecataloguename2',
          prop: 'pimtitlecataloguename2',
          dataType: 'PICKUPTEXT',
        },
        {
          name: 'pimtitlecatalogueid2',
          prop: 'pimtitlecatalogueid2',
          dataType: 'PICKUP',
        },
        {
          name: 'dh',
          prop: 'dh',
          dataType: 'TEXT',
        },
        {
          name: 'ormorgid',
          prop: 'ormorgid',
          dataType: 'PICKUP',
        },
        {
          name: 'pimtitlecataloguename',
          prop: 'pimtitlecataloguename',
          dataType: 'TEXT',
        },
        {
          name: 'zclc',
          prop: 'zclc',
          dataType: 'SSCODELIST',
        },
        {
          name: 'zclc_text',
          prop: 'zclc',
          dataType: 'SSCODELIST',
        },
        {
          name: 'pxh',
          prop: 'pxh',
          dataType: 'INT',
        },
        {
          name: 'srfmajortext',
          prop: 'pimtitlecataloguename',
          dataType: 'TEXT',
        },
        {
          name: 'srfdataaccaction',
          prop: 'pimtitlecatalogueid',
          dataType: 'GUID',
        },
        {
          name: 'srfkey',
          prop: 'pimtitlecatalogueid',
          dataType: 'GUID',
        },
        {
          name: 'pimtitlecatalogue',
          prop: 'pimtitlecatalogueid',
        },
      {
        name: 'n_pimtitlecataloguename_like',
        prop: 'n_pimtitlecataloguename_like',
        dataType: 'TEXT',
      },
      {
        name: 'n_dh_eq',
        prop: 'n_dh_eq',
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