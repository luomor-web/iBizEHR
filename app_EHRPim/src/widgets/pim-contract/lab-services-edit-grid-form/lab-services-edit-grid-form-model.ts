/**
 * LabServices_EditGrid 部件模型
 *
 * @export
 * @class LabServices_EditGridModel
 */
export default class LabServices_EditGridModel {

  /**
  * 获取数据项集合
  *
  * @returns {any[]}
  * @memberof LabServices_EditGridModel
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
        prop: 'pimcontractid',
        dataType: 'GUID',
      },
      {
        name: 'srfmajortext',
        prop: 'pimpersonname',
        dataType: 'PICKUPTEXT',
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
        name: 'pimpersonid',
        prop: 'pimpersonid',
        dataType: 'PICKUP',
      },
      {
        name: 'pimpersonname',
        prop: 'pimpersonname',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'htbh',
        prop: 'htbh',
        dataType: 'TEXT',
      },
      {
        name: 'contracttype',
        prop: 'contracttype',
        dataType: 'SSCODELIST',
      },
      {
        name: 'qsrq',
        prop: 'qsrq',
        dataType: 'DATE',
      },
      {
        name: 'jsrq',
        prop: 'jsrq',
        dataType: 'DATE',
      },
      {
        name: 'htzt',
        prop: 'htzt',
        dataType: 'SSCODELIST',
      },
      {
        name: 'ormorgname',
        prop: 'ormorgname',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'sydqsj',
        prop: 'sydqsj',
        dataType: 'DATE',
      },
      {
        name: 'pimlabourcampanyname',
        prop: 'pimlabourcampanyname',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'ormorgid',
        prop: 'ormorgid',
        dataType: 'PICKUP',
      },
      {
        name: 'orgid',
        prop: 'orgid',
        dataType: 'TEXT',
      },
      {
        name: 'personorgid',
        prop: 'personorgid',
        dataType: 'PICKUPDATA',
      },
      {
        name: 'pimcontractid',
        prop: 'pimcontractid',
        dataType: 'GUID',
      },
      {
        name: 'pimlabourcampanyid',
        prop: 'pimlabourcampanyid',
        dataType: 'PICKUP',
      },
      {
        name: 'pimcontract',
        prop: 'pimcontractid',
        dataType: 'FONTKEY',
      },
    ]
  }

}