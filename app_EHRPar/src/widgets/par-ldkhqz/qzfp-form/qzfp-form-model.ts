/**
 * QZFP 部件模型
 *
 * @export
 * @class QZFPModel
 */
export default class QZFPModel {

  /**
  * 获取数据项集合
  *
  * @returns {any[]}
  * @memberof QZFPModel
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
        prop: 'parldkhqzid',
        dataType: 'GUID',
      },
      {
        name: 'srfmajortext',
        prop: 'parldkhqzname',
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
        name: 'khobject',
        prop: 'khobject',
        dataType: 'SSCODELIST',
      },
      {
        name: 'pfzt',
        prop: 'pfzt',
        dataType: 'SSCODELIST',
      },
      {
        name: 'qzzb',
        prop: 'qzzb',
        dataType: 'FLOAT',
      },
      {
        name: 'parldkhqzid',
        prop: 'parldkhqzid',
        dataType: 'GUID',
      },
      {
        name: 'parldkhqz',
        prop: 'parldkhqzid',
        dataType: 'FONTKEY',
      },
    ]
  }

}