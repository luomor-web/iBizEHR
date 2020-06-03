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
          name: 'htlx_text',
          prop: 'htlx',
          dataType: 'SSCODELIST',
        },
        {
          name: 'htzt',
          prop: 'htzt',
          dataType: 'SSCODELIST',
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
          name: 'pimlabourcampanyid',
          prop: 'pimlabourcampanyid',
          dataType: 'PICKUP',
        },
        {
          name: 'qsrq',
          prop: 'qsrq',
          dataType: 'DATE',
        },
        {
          name: 'htlx',
          prop: 'htlx',
          dataType: 'SSCODELIST',
        },
        {
          name: 'jsrq',
          prop: 'jsrq',
          dataType: 'DATE',
        },
        {
          name: 'htsyts_color',
          prop: 'htsyts_color',
          dataType: 'INT',
        },
        {
          name: 'srfmajortext',
          prop: 'pimpersonname',
          dataType: 'PICKUPTEXT',
        },
        {
          name: 'srfdataaccaction',
          prop: 'pimcontractid',
          dataType: 'GUID',
        },
        {
          name: 'srfkey',
          prop: 'pimcontractid',
          dataType: 'GUID',
        },
        {
          name: 'contracttype',
          prop: 'contracttype',
          dataType: 'SSCODELIST',
        },
        {
          name: 'sydqsj',
          prop: 'sydqsj',
          dataType: 'DATE',
        },
        {
          name: 'ormsignorgid',
          prop: 'ormsignorgid',
          dataType: 'PICKUP',
        },
        {
          name: 'contracttype_text',
          prop: 'contracttype',
          dataType: 'SSCODELIST',
        },
        {
          name: 'contractsignorgid',
          prop: 'contractsignorgid',
          dataType: 'PICKUP',
        },
        {
          name: 'htbh',
          prop: 'htbh',
          dataType: 'TEXT',
        },
        {
          name: 'pimcontract',
          prop: 'pimcontractid',
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