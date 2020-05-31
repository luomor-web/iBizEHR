/**
 * Main_2 部件模型
 *
 * @export
 * @class Main_2Model
 */
export default class Main_2Model {

	/**
	 * 是否是实体数据导出
	 *
	 * @returns {any[]}
	 * @memberof Main_2GridMode
	 */
	public isDEExport: boolean = false;

	/**
	 * 获取数据项集合
	 *
	 * @returns {any[]}
	 * @memberof Main_2GridMode
	 */
	public getDataItems(): any[] {
    if(this.isDEExport){
		  return [
      ]
    }else{
		  return [
        {
          name: 'sxzy',
          prop: 'sxzy',
          dataType: 'TEXT',
        },
        {
          name: 'byyx',
          prop: 'byyx',
          dataType: 'TEXT',
        },
        {
          name: 'pimpersonid',
          prop: 'pimpersonid',
          dataType: 'PICKUP',
        },
        {
          name: 'xl',
          prop: 'xl',
          dataType: 'SSCODELIST',
        },
        {
          name: 'jssj',
          prop: 'jssj',
          dataType: 'DATE',
        },
        {
          name: 'xkml',
          prop: 'xkml',
          dataType: 'SSCODELIST',
        },
        {
          name: 'sfdyxl',
          prop: 'sfdyxl',
          dataType: 'YESNO',
        },
        {
          name: 'xllx_text',
          prop: 'xllx',
          dataType: 'SSCODELIST',
        },
        {
          name: 'xxxz',
          prop: 'xxxz',
          dataType: 'SSCODELIST',
        },
        {
          name: 'srfmajortext',
          prop: 'pimeducationname',
          dataType: 'TEXT',
        },
        {
          name: 'srfdataaccaction',
          prop: 'pimeducationid',
          dataType: 'GUID',
        },
        {
          name: 'srfkey',
          prop: 'pimeducationid',
          dataType: 'GUID',
        },
        {
          name: 'sfzgxl',
          prop: 'sfzgxl',
          dataType: 'YESNO',
        },
        {
          name: 'qssj',
          prop: 'qssj',
          dataType: 'DATE',
        },
        {
          name: 'xl_text',
          prop: 'xl',
          dataType: 'SSCODELIST',
        },
        {
          name: 'xllx',
          prop: 'xllx',
          dataType: 'SSCODELIST',
        },
        {
          name: 'xkml_text',
          prop: 'xkml',
          dataType: 'SSCODELIST',
        },
        {
          name: 'xxxz_text',
          prop: 'xxxz',
          dataType: 'SSCODELIST',
        },
        {
          name: 'pimeducation',
          prop: 'pimeducationid',
        },
      {
        name: 'n_pimpersonid_eq',
        prop: 'n_pimpersonid_eq',
        dataType: 'PICKUP',
      },
      {
        name: 'n_pimpersonname_like',
        prop: 'n_pimpersonname_like',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'n_xl_eq',
        prop: 'n_xl_eq',
        dataType: 'SSCODELIST',
      },
      {
        name: 'n_xxxz_eq',
        prop: 'n_xxxz_eq',
        dataType: 'SSCODELIST',
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