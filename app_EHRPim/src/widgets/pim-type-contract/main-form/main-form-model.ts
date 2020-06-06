/**
 * Main 部件模型
 *
 * @export
 * @class MainModel
 */
export default class MainModel {

  /**
  * 获取数据项集合
  *
  * @returns {any[]}
  * @memberof MainModel
  */
  public getDataItems(): any[] {
    return [
      {
        name: 'srfwfmemo',
        prop: 'srfwfmemo',
        dataType: 'TEXT',
      },
      // 前端新增修改标识，新增为"0",修改为"1"或未设值
      {
        name: 'srffrontuf',
        prop: 'srffrontuf',
        dataType: 'TEXT',
      },
      {
        name: 'srfupdatedate',
        prop: 'updatedate',
        dataType: 'DATETIME',
      },
      {
        name: 'srforikey',
      },
      {
        name: 'srfkey',
        prop: 'pimtypecontractid',
        dataType: 'GUID',
      },
      {
        name: 'srfmajortext',
        prop: 'pimtypecontractname',
        dataType: 'TEXT',
      },
      {
        name: 'srftempmode',
      },
      {
        name: 'srfuf',
      },
      {
        name: 'srfdeid',
      },
      {
        name: 'srfsourcekey',
      },
      {
        name: 'sortno',
        prop: 'sortno',
        dataType: 'INT',
      },
      {
        name: 'pimtypecontractname',
        prop: 'pimtypecontractname',
        dataType: 'TEXT',
      },
      {
        name: 'contractlife',
        prop: 'contractlife',
        dataType: 'INT',
      },
      {
        name: 'pimtypecontractid',
        prop: 'pimtypecontractid',
        dataType: 'GUID',
      },
      {
        name: 'pimtypecontract',
        prop: 'pimtypecontractid',
        dataType: 'FONTKEY',
      },
    ]
  }

}