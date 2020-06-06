/**
 * CK 部件模型
 *
 * @export
 * @class CKModel
 */
export default class CKModel {

	/**
	 * 是否是实体数据导出
	 *
	 * @returns {any[]}
	 * @memberof CKGridMode
	 */
	public isDEExport: boolean = false;

	/**
	 * 获取数据项集合
	 *
	 * @returns {any[]}
	 * @memberof CKGridMode
	 */
	public getDataItems(): any[] {
    if(this.isDEExport){
		  return [
      ]
    }else{
		  return [
        {
          name: 'yjyy',
          prop: 'yjyy',
          dataType: 'TEXT',
        },
        {
          name: 'approvalopinion',
          prop: 'approvalopinion',
          dataType: 'TEXT',
        },
        {
          name: 'pimbyzzjlmxid',
          prop: 'pimbyzzjlmxid',
          dataType: 'PICKUP',
        },
        {
          name: 'approver',
          prop: 'approver',
          dataType: 'TEXT',
        },
        {
          name: 'passorreject',
          prop: 'passorreject',
          dataType: 'SSCODELIST',
        },
        {
          name: 'pcmprofileid',
          prop: 'pcmprofileid',
          dataType: 'PICKUP',
        },
        {
          name: 'srfmajortext',
          prop: 'pcmprofileapprovalname',
          dataType: 'TEXT',
        },
        {
          name: 'srfdataaccaction',
          prop: 'pcmprofileapprovalid',
          dataType: 'GUID',
        },
        {
          name: 'srfkey',
          prop: 'pcmprofileapprovalid',
          dataType: 'GUID',
        },
        {
          name: 'approvaldate',
          prop: 'approvaldate',
          dataType: 'DATE',
        },
        {
          name: 'pcmprofileapproval',
          prop: 'pcmprofileapprovalid',
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