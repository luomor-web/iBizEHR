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
        prop: 'trmstayid',
        dataType: 'GUID',
      },
      {
        name: 'srfmajortext',
        prop: 'trmstayname',
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
        name: 'fjlx',
        prop: 'fjlx',
        dataType: 'SSCODELIST',
      },
      {
        name: 'fjsl',
        prop: 'fjsl',
        dataType: 'INT',
      },
      {
        name: 'trmtrainaddressid',
        prop: 'trmtrainaddressid',
        dataType: 'PICKUP',
      },
      {
        name: 'trmstayid',
        prop: 'trmstayid',
        dataType: 'GUID',
      },
      {
        name: 'trmstay',
        prop: 'trmstayid',
        dataType: 'FONTKEY',
      },
    ]
  }

}