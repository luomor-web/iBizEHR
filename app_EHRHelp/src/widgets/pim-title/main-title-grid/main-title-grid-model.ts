/**
 * Main_Title 部件模型
 *
 * @export
 * @class Main_TitleModel
 */
export default class Main_TitleModel {

	/**
	 * 是否是实体数据导出
	 *
	 * @returns {any[]}
	 * @memberof Main_TitleGridMode
	 */
	public isDEExport: boolean = false;

	/**
	 * 获取数据项集合
	 *
	 * @returns {any[]}
	 * @memberof Main_TitleGridMode
	 */
	public getDataItems(): any[] {
    if(this.isDEExport){
		  return [
      ]
    }else{
		  return [
        {
          name: 'zcdj',
          prop: 'zcdj',
          dataType: 'SSCODELIST',
        },
        {
          name: 'pimtitlecatalogueid',
          prop: 'pimtitlecatalogueid',
          dataType: 'PICKUP',
        },
        {
          name: 'employtime',
          prop: 'employtime',
          dataType: 'DATE',
        },
        {
          name: 'lssuingagency',
          prop: 'lssuingagency',
          dataType: 'TEXT',
        },
        {
          name: 'zcbh',
          prop: 'zcbh',
          dataType: 'TEXT',
        },
        {
          name: 'zcdj_text',
          prop: 'zcdj',
          dataType: 'SSCODELIST',
        },
        {
          name: 'pimpersonid',
          prop: 'pimpersonid',
          dataType: 'PICKUP',
        },
        {
          name: 'pimtitlecataloguename',
          prop: 'pimtitlecataloguename',
          dataType: 'PICKUPTEXT',
        },
        {
          name: 'sfzgzc',
          prop: 'sfzgzc',
          dataType: 'YESNO',
        },
        {
          name: 'srfmajortext',
          prop: 'pimpersonname',
          dataType: 'PICKUPTEXT',
        },
        {
          name: 'srfdataaccaction',
          prop: 'pimtitleid',
          dataType: 'GUID',
        },
        {
          name: 'srfkey',
          prop: 'pimtitleid',
          dataType: 'GUID',
        },
        {
          name: 'reviewbody',
          prop: 'reviewbody',
          dataType: 'TEXT',
        },
        {
          name: 'jlspzt',
          prop: 'jlspzt',
          dataType: 'SSCODELIST',
        },
        {
          name: 'majorengaged',
          prop: 'majorengaged',
          dataType: 'SSCODELIST',
        },
        {
          name: 'zchqrq',
          prop: 'zchqrq',
          dataType: 'DATE',
        },
        {
          name: 'pimtitle',
          prop: 'pimtitleid',
        },
      {
        name: 'n_ygbh_like',
        prop: 'n_ygbh_like',
        dataType: 'PICKUPDATA',
      },
      {
        name: 'n_pimpersonname_like',
        prop: 'n_pimpersonname_like',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'n_pimtitlecataloguename_like',
        prop: 'n_pimtitlecataloguename_like',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'n_zcdj_eq',
        prop: 'n_zcdj_eq',
        dataType: 'SSCODELIST',
      },
      {
        name: 'n_sfzgzc_eq',
        prop: 'n_sfzgzc_eq',
        dataType: 'YESNO',
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