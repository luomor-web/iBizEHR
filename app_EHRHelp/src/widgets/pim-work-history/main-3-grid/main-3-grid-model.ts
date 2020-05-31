/**
 * Main_3 部件模型
 *
 * @export
 * @class Main_3Model
 */
export default class Main_3Model {

	/**
	 * 是否是实体数据导出
	 *
	 * @returns {any[]}
	 * @memberof Main_3GridMode
	 */
	public isDEExport: boolean = false;

	/**
	 * 获取数据项集合
	 *
	 * @returns {any[]}
	 * @memberof Main_3GridMode
	 */
	public getDataItems(): any[] {
    if(this.isDEExport){
		  return [
      ]
    }else{
		  return [
        {
          name: 'rzkssj',
          prop: 'rzkssj',
          dataType: 'DATE',
        },
        {
          name: 'ormpostname',
          prop: 'ormpostname',
          dataType: 'TEXT',
        },
        {
          name: 'cfplx',
          prop: 'cfplx',
          dataType: 'SSCODELIST',
        },
        {
          name: 'pimpersonid',
          prop: 'pimpersonid',
          dataType: 'PICKUP',
        },
        {
          name: 'ormrankid',
          prop: 'ormrankid',
          dataType: 'PICKUP',
        },
        {
          name: 'srfmajortext',
          prop: 'pimworkhistoryname',
          dataType: 'TEXT',
        },
        {
          name: 'srfdataaccaction',
          prop: 'pimworkhistoryid',
          dataType: 'GUID',
        },
        {
          name: 'srfkey',
          prop: 'pimworkhistoryid',
          dataType: 'GUID',
        },
        {
          name: 'ormdutyname',
          prop: 'ormdutyname',
          dataType: 'TEXT',
        },
        {
          name: 'ormorgname',
          prop: 'ormorgname',
          dataType: 'TEXT',
        },
        {
          name: 'ormorgsectorname',
          prop: 'ormorgsectorname',
          dataType: 'TEXT',
        },
        {
          name: 'cfplx_text',
          prop: 'cfplx',
          dataType: 'SSCODELIST',
        },
        {
          name: 'jlspzt',
          prop: 'jlspzt',
          dataType: 'SSCODELIST',
        },
        {
          name: 'experience',
          prop: 'experience',
          dataType: 'YESNO',
        },
        {
          name: 'rzjssj',
          prop: 'rzjssj',
          dataType: 'DATE',
        },
        {
          name: 'jlss',
          prop: 'jlss',
          dataType: 'SSCODELIST',
        },
        {
          name: 'pimworkhistory',
          prop: 'pimworkhistoryid',
        },
      {
        name: 'n_pimpersonname_like',
        prop: 'n_pimpersonname_like',
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