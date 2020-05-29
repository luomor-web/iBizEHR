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
          name: 'legalentity',
          prop: 'legalentity',
          dataType: 'SSCODELIST',
        },
        {
          name: 'porgid',
          prop: 'porgid',
          dataType: 'PICKUP',
        },
        {
          name: 'porgname',
          prop: 'porgname',
          dataType: 'PICKUPTEXT',
        },
        {
          name: 'btqy_text',
          prop: 'btqy',
          dataType: 'SSCODELIST',
        },
        {
          name: 'srfmajortext',
          prop: 'orgname',
          dataType: 'TEXT',
        },
        {
          name: 'srfdataaccaction',
          prop: 'orgid',
          dataType: 'GUID',
        },
        {
          name: 'srfkey',
          prop: 'orgid',
          dataType: 'GUID',
        },
        {
          name: 'zzlx',
          prop: 'zzlx',
          dataType: 'SSCODELIST',
        },
        {
          name: 'correspondingorg',
          prop: 'correspondingorg',
          dataType: 'TEXT',
        },
        {
          name: 'startstopsign',
          prop: 'startstopsign',
          dataType: 'SSCODELIST',
        },
        {
          name: 'orgcode',
          prop: 'orgcode',
          dataType: 'TEXT',
        },
        {
          name: 'btqy',
          prop: 'btqy',
          dataType: 'SSCODELIST',
        },
        {
          name: 'px',
          prop: 'px',
          dataType: 'INT',
        },
        {
          name: 'gsss',
          prop: 'gsss',
          dataType: 'SSCODELIST',
        },
        {
          name: 'orgname',
          prop: 'orgname',
          dataType: 'TEXT',
        },
        {
          name: 'shortname',
          prop: 'shortname',
          dataType: 'TEXT',
        },
        {
          name: 'levelcode',
          prop: 'levelcode',
          dataType: 'TEXT',
        },
        {
          name: 'zzcjsj',
          prop: 'zzcjsj',
          dataType: 'DATE',
        },
        {
          name: 'gsss_text',
          prop: 'gsss',
          dataType: 'SSCODELIST',
        },
        {
          name: 'ormorg',
          prop: 'orgid',
        },
      {
        name: 'n_orgcode_like',
        prop: 'n_orgcode_like',
        dataType: 'TEXT',
      },
      {
        name: 'n_orgname_like',
        prop: 'n_orgname_like',
        dataType: 'TEXT',
      },
      {
        name: 'n_shortname_like',
        prop: 'n_shortname_like',
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